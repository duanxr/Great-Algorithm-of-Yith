package com.duanxr.yith.middle;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

/**
 * @author Duanran 4/22/2020
 */
public class BuildingH2O {

  class H2O {

    private Semaphore o = new Semaphore(1);
    private Semaphore h = new Semaphore(2);
    public H2O() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
      h.acquire(1);
      // releaseHydrogen.run() outputs "H". Do not change or remove this line.
      releaseHydrogen.run();
      o.release(2);
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
      o.acquire(2);
      // releaseOxygen.run() outputs "O". Do not change or remove this line.
      releaseOxygen.run();
      h.release(2);
    }
  }
}
