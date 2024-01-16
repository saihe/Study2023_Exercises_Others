package ksaito.study2023.murata.domain.repository;

import java.util.List;
import ksaito.study2023.murata.domain.model.Subscription;

public interface SubscriptionRepository {
  List<Subscription> list();
  void save(Subscription record);
}
