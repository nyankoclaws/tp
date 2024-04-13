---
layout: default.md
title: "Wei Hao's Project Portfolio Page"
---

### Project: Dormie

Dormie is an application developed for college students living in dorms. It helps them connect with their dorm mates in a simple way. With Dormie, they can easily see when their friends are free, and keep track of their important dates and contact details. It makes organising social events less stressful and helps students stay connected with each other.

Given below are my contributions to the project.

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2324s2.github.io/tp-dashboard/?search=justweihao&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2024-02-23&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)
* **New Feature**: Added `whoIsFree` command.
    * What it does: Allows users to find a free person whose `freeTimeTag` satisfies the given input time.
    * Justification: This feature improves the product significantly because the target users for the application are students that stay in dorm, and students staying in dorm in NUS benefit from the application by filtering contacts who are free to arrange a meetup.
    * Highlights: The implementation was challenging as it required changes to the existing `find` function to be more OOP style because we are filtering using different criteria. Besides, this command relies on the `freeTimeTag` field, which is implemented by another team member. Hence, collaboration is a key factor in the successful implementation of this feature.
    * `whoIsFree` command: [\#105](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/105)
* **Modified existing features**:
    * Change the implementation of `Birthday` from `String` to `LocalDate` [\#59](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/59)
* **Enhancements to features**:
    * Wrote additional tests for `AddCommandParser` [\#83](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/83)
    * Enable multiple indices for `edit` command. [\#96](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/96)
* **Documentation**:
    * User Guide:
        * Added command summary to User Guide. [\#119](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/119)
        * Added glossary to User Guide. [\#140](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/140)
        * Fix the icon, badges, link to release of UG[\#80](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/80)
    * Developer Guide:
        * Added NFR and Glossaries. [\#24](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/24)
* **Community**:
    * PRs reviewed (with non-trivial review comments): [\#78](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/78)
