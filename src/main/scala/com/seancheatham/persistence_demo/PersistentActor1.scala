package com.seancheatham.persistence_demo

import akka.actor.ActorLogging
import akka.persistence.{PersistentActor, SnapshotOffer}

class PersistentActor1 extends PersistentActor with ActorLogging {

  private var state: PersistentActor1.State =
    PersistentActor1.State(0)

  val receiveRecover: Receive = {
    case PersistentActor1.Events.StateIncremented(_) =>
      state = state.incremented
    case SnapshotOffer(_, snapshot: PersistentActor1.State) =>
      state = snapshot

  }

  val receiveCommand: Receive = {
    case PersistentActor1.Commands.IncrementState =>
      persist(PersistentActor1.Events.StateIncremented(System.currentTimeMillis())) { event =>
        state = state.incremented
        context.system.eventStream.publish(event)
        if (lastSequenceNr >= 0 && lastSequenceNr % 10 == 0) // Only snapshot after every 10 events
          saveSnapshot(state)
      }
  }

  val persistenceId: String = "persistent-actor-1"
}

object PersistentActor1 {

  case class State(count: Int) {
    def incremented: State = copy(count + 1)
  }

  object Commands {

    case object IncrementState

  }

  object Events {

    case class StateIncremented(timestamp: Long)

  }

}