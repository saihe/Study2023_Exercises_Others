package ksaito.study2023.murata.infrastructure.memory;

import ksaito.study2023.murata.domain.model.Subscription;
import ksaito.study2023.murata.domain.repository.SubscriptionRepository;

import java.util.LinkedList;
import java.util.List;

public class SubscriptionRepositoryImpl implements SubscriptionRepository {
  private final List<Subscription> dataStore;

  public SubscriptionRepositoryImpl() {
    dataStore = new LinkedList<>();
  }

  @Override
  public List<Subscription> list() {
    return dataStore;
  }

  @Override
  public void save(Subscription record) {
    dataStore.add(record);
  }
}
