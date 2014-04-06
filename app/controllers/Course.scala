package controllers

import models._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

object Course extends Controller{
  def newCourse = Action {
    Ok(views.html.course.newCourse())
  }

  val course = Form(
    mapping(
      "name" -> text,
      "content" -> text
    )(Courses.apply)(Courses.unapply)
  )

  def create = Action { implicit rs =>
    Ok(course.bindFromRequest.get.name)
  }
}