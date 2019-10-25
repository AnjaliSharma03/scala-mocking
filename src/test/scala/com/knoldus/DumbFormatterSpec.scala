package com.knoldus

import java.util.Date
import org.mockito.Matchers._
import org.mockito.Mockito.{ when, _ }
import org.mockito.invocation.InvocationOnMock
import org.mockito.stubbing.Answer
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{ FlatSpec, Matchers }

class DumbFormatterSpec extends FlatSpec with Matchers with MockitoSugar {

  "Testing using Mockito " should "be easy" in {

    val mockDumbFormatter = mock[DumbFormatter]
    when(mockDumbFormatter.getDate()).thenReturn("01/01/2015")
    assert("01/01/2015" === mockDumbFormatter.getDate())
  }

  "Matching Argument using Mockito " should "be easy" in {

    val mockDumbFormatter = mock[DumbFormatter]
    when(mockDumbFormatter.formatWithDataTimePrefix(anyString(), any[Date]())).thenReturn("01/01/2015 Something")
    assert("01/01/2015 Something" === mockDumbFormatter.formatWithDataTimePrefix("blah blah blah", new Date()))
  }

  "Throwing Exception using Mockito " should "be easy" in {

    val mockDumbFormatter = mock[DumbFormatter]
    when(mockDumbFormatter.formatWithDataTimePrefix(anyString(), any[Date]())).thenThrow(new RuntimeException())

    intercept[RuntimeException] {
      mockDumbFormatter.formatWithDataTimePrefix("blah blah blah", new Date())
    }
  }

  "Callbacks using Mockito " should "be easy" in {

    val mockDumbFormatter = mock[DumbFormatter]
    when(mockDumbFormatter.formatWithDataTimePrefix(anyString(), any[Date]())).thenAnswer(new Answer[String] {
      ()
      override def answer(invocation: InvocationOnMock): String = {
        val result = "called back nicely"
        result
      }
    })

    assert("called back nicely" === mockDumbFormatter.formatWithDataTimePrefix("blah blah blah", new Date()))

  }

  "Verification using Mockito " should "be easy" in {

    val mockDumbFormatter = mock[DumbFormatter]
    when(mockDumbFormatter.formatWithDataTimePrefix(anyString(), any[Date]())).thenReturn("someString")

    val theDate = new Date()
    mockDumbFormatter.formatWithDataTimePrefix("blah blah blah", theDate)
    mockDumbFormatter.formatWithDataTimePrefix("no no no", theDate)

    verify(mockDumbFormatter, atLeastOnce()).formatWithDataTimePrefix("blah blah blah", theDate)
    verify(mockDumbFormatter, times(1)).formatWithDataTimePrefix("no no no", theDate)

  }
}
