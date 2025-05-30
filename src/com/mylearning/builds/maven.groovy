package com.mylearning.builds;

class Mvn {
  def jenkins
    Mvn(jenkins) {
        this.jenkins = jenkins
    }
    
 def run(args){
 jenkins.sh """ ${args}
 """
 }
