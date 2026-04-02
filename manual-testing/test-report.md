# Test Report – E-Commerce Web App

**Report Date:** February 22, 2026

---

## 1. General Information

| Field | Details |
|---|---|
| Product | E-Commerce Web App |
| Version | 1.0 |
| Testing Type | Functional |
| Testing Period | 1 Week |
| Test Effort | 32 hours |

---

## 2. Testing Results Summary

| Total Test Cases | Passed | Failed | Blocked | Not Tested | Pass Rate |
|---|---|---|---|---|---|
| 76 | 57 | 14 | 5 | 0 | 75.00% |

---

## 3. Functional Coverage per Feature

| Feature | Total TCs | Pass Coverage (%) |
|---|---|---|
| Cart | 14 | 64.29% |
| Checkout | 14 | 71.43% |
| Login | 13 | 100.00% |
| Logout | 7 | 100.00% |
| Order Summary | 18 | 50.00% |
| Inventory | 10 | 90.00% |

---

## 4. Defect Tracking

| Bug ID | Feature | Test Case ID | Status | Priority |
|---|---|---|---|---|
| BUG-01 | Inventory | I02 | Failed | Low |
| BUG-02 | Cart | C01 | Failed | High |
| BUG-03 | Cart | C02 | Failed | High |
| BUG-04 | Cart | C06 | Failed | High |
| BUG-05 | Cart | C07 | Failed | High |
| BUG-06 | Cart | C13 | Failed | Medium |
| BUG-07 | Checkout | CO05 | Failed | Medium |
| BUG-08 | Checkout | CO08 | Failed | Medium |
| BUG-09 | Checkout | CO11 | Failed | High |
| BUG-10 | Checkout | CO14 | Failed | High |
| BUG-11 | Order Summary | OS03 | Failed | High |
| BUG-12 | Order Summary | OS07 | Failed | High |
| BUG-13 | Order Summary | OS09 | Blocked | High |
| BUG-14 | Order Summary | OS10 | Blocked | High |
| BUG-15 | Order Summary | OS11 | Failed | High |
| BUG-16 | Order Summary | OS15 | Failed | High |
| BUG-17 | Order Summary | OS16 | Blocked | High |
| BUG-18 | Order Summary | OS17 | Blocked | High |
| BUG-19 | Order Summary | OS18 | Blocked | High |

---

## 5. Defect Metrics

### By Priority

| Priority | Number of Defects |
|---|---|
| High | 15 |
| Medium | 3 |
| Low | 1 |
| **Total** | **19** |

### Additional Metrics

| Metric | Value |
|---|---|
| Total features tested | 6 |
| Defect Density (Defects / Total TCs) | 0.25 |
| Features with 100% pass rate | 33.33% (Login, Logout) |

---

## 6. Release Recommendation

> ⚠️ **Release is NOT recommended** until all high priority defects are resolved and retested.

---

## 7. Conclusions

**Scope:** Functional testing was executed across the following features: Login, Inventory, Cart, Checkout, Order Summary, Logout.

A total of **76 test cases** were executed, achieving an overall pass rate of **75.00%**.

Overall quality status is **below release readiness** due to 14 Failed and 5 Blocked test cases. Defects must be resolved and retested before release.

Defects impact core user flows, specifically: **Cart**, **Checkout**, and **Order Summary**. This affects shopping cart operations, checkout processing, and order completion.

**Recommended next steps:**
- Prioritize defect fixes by priority (High → Medium → Low)
- Perform targeted regression testing on affected areas
- Re-execute blocked test cases once prerequisites are resolved
