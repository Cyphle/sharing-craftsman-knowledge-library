package fr.knowledge.domain.favorites.events;

import fr.knowledge.domain.common.DomainEvent;
import fr.knowledge.domain.common.valueobjects.Id;

public class SelectionRemovedEvent implements DomainEvent {
  private Id id;

  public SelectionRemovedEvent(Id id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    SelectionRemovedEvent that = (SelectionRemovedEvent) o;

    return id != null ? id.equals(that.id) : that.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "SelectionRemovedEvent{" +
            "id=" + id +
            '}';
  }
}