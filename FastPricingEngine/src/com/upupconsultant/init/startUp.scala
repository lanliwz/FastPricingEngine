package com.upupconsultant.init
import com.upupconsultant.pricing.rule.RuleManager;
import com.upupconsultant.pricing.io.FileDao
import com.upupconsultant.pricing.model._
//import java.util.ArrayList
//import java.util.List
import scala.collection.mutable.ArrayBuffer
import scala.collection.JavaConverters._


object startUp extends App {
  val rmgr = new RuleManager();
  val dao = new FileDao()
  rmgr.setRuleTemplateRoot("/Users/lanliwz/git/FastPEngine/FastPricingEngine/rulefiles");
  rmgr.setRuleTemplateName("CostSharingTemplate.drt");
  rmgr.setDao(new FileDao());
  rmgr.setRuleFileRoot("/Users/lanliwz/FastPricingEngine/rule");
  rmgr.setRuleFileBackupRoot("/Users/lanliwz/FastPricingEngine/ruleBackup");
  val rule1 = new SplitRule(100l);
    rule1.setRuleName("test rule 100");
    rule1.setActivationGroup("pricing");
    rule1.setAgendaGroup("tier1pricing");
    rule1.setProviderId(1000000l);
    val action = new BasicSplitInstruction("PERCENTAGE",50l);
        
    rule1.setAction(action);
    
    var items = List(( new StringRuleItem("providerId","EQUAL_TO","200000")).asInstanceOf[SplitRuleItem])
    rule1.setRuleItems(items.asJava)
    
    var rules = List(rule1)
    var str = rmgr.getDrl(rules.asJava, rmgr.getRuleTemplateName())
    println(str)
    


}
case class TRule(id:Long,activationGroup:String,agendaGroup:String)