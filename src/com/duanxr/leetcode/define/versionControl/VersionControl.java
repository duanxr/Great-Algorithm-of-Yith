package com.duanxr.leetcode.define.versionControl;


/**
 * @author Duanran 2019/2/27 0027
 */
public class VersionControl {

  private static final int firstBadVersion = 12;

  public boolean isBadVersion(int version) {
    return version >= firstBadVersion;
  }
}
