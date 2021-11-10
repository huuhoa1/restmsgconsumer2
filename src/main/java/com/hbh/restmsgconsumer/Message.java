package com.hbh.restmsgconsumer;


import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Message {

  private @Id @GeneratedValue Long id;
  private String msg;

  Message() {}

  Message(String msg) {

    this.msg = msg;
  }

  public Long getId() {
    return this.id;
  }

  public String getMsg() {
    return this.msg;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }


  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Message))
      return false;
    Message message = (Message) o;
    return Objects.equals(this.id, message.id) && Objects.equals(this.msg, message.msg);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.msg);
  }

  @Override
  public String toString() {
    return "message{" + "id=" + this.id + ", msg='" + this.msg + '\'' + '}';
  }
}
