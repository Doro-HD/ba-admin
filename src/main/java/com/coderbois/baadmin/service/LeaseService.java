package com.coderbois.baadmin.service;
import com.coderbois.baadmin.model.Lease;
import com.coderbois.baadmin.repository.LeaseRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Service
public class LeaseService {

      private final LeaseRepository leaseRepository;

      public LeaseService(LeaseRepository leaseRepository) {
            this.leaseRepository = leaseRepository;
      }

      public boolean saveLease(Lease lease) {
            LocalDate myDate = LocalDate.now();
            LocalDate theDate = myDate.plusMonths(lease.getAmountOfMonths());
            DateTimeFormatter myFormater = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            lease.setStringDate(theDate.format(myFormater));
            this.leaseRepository.saveLease(lease);
            return true;
      }

      public LeasingStatistic calculateBusinessInfo() {
            ArrayList<Lease> allLeases = this.leaseRepository.getAllLeases();
            double allAmount = 0;
            for (Lease lease : allLeases) {
                  allAmount = allAmount + lease.getMonthlyPay();
            }
            int countLease = allLeases.size();
            return (new LeasingStatistic(allLeases, allAmount, countLease));
      }

      public ArrayList<Lease> leaseBySearch(){

      }
}






