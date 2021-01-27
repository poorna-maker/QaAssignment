@QaVersionFeature
   Feature: Finding app name
     Background: cloud control app

     Scenario Outline: Find app name which has version as null
       Given MicroService Version
       When Enter environment name as <arg0>
       Then app name printed for null
       Examples:
         | arg0  |
         | "Qa1" |

     Scenario Outline: Find app name which has version mismatch
       Given MicroService Version
       When Find Mismatch environment for <arg0> and <arg1>
       Then app name printed for mismatch
       Examples:
         | arg0      | arg1   |
         | "Qa1" | "QA2" |

     Scenario Outline: To find whether environment contains SNAPSHOT
       Given User should be in the Microtracker Page
       When User gives the environment name as <environment>
       Then User will land on the result page
       Examples:
         | environment |
 #  |"Qa1"        |
         |"QA2"        |
   #|"Preprod"        |