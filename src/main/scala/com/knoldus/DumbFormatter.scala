package com.knoldus

import java.util.Date

trait DumbFormatter {

  def formatWithDataTimePrefix(inputString: String, date: Date): String =
    s"date : $date : $inputString"

  def getDate(): String =
    new Date().toString
}
