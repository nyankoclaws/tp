---
layout: default.md
title: "Chee Xiang's Project Portfolio Page"
---

### Project: Dormie

Dormie is an application developed for college students living in dorms. It helps them connect with their dorm mates in a simple way. With Dormie, they can easily see when their friends are free, and keep track of their important dates and contact details. It makes organising social events less stressful and helps students stay connected with each other.

Given below are my contributions to the project.

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2324s2.github.io/tp-dashboard/?search=palloncx&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2024-02-23&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)
* **New Feature**: Added dorm tag as a new field for each contact.
  * What it does: Allows users to perform commands on dorm tag.
  * Justification: This feature improves the product significantly because the target users for the application are students that stay in dorm, and students can be staying in different dorm in NUS. Hence, dorm tag, together with room number, provides more accurate identification on user location.
  * Highlights: The implementation was challenging as it required changes to all commands that involve contact fields, which includes relevant parsers, models, and test cases.
  * `dormTag` field: [\#98](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/98)
* **Modified existing features**:
  * Enable optional input for some fields (email, room number, telegram handle, birthday, dorm tag, free time tag) during contact creation. [\#56](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/56)
* **Project management**:
  * Managed releases `v1.1` - `v1.2.1` (3 releases) on GitHub
* **Enhancements to features**:
  * Wrote additional tests for various class [\#98](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/98)
  * Disallowed duplicate prefix for fields in certain commands [\#113](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/113)
  * Enable assertion for the project [\#90](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/90)
* **Documentation**:
  * User Guide:
    * Added glossary to explain uncommon terms in the User Guide. [\#117](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/117)
    * Enhanced documentation for all features, and arranged them in lexicographical order. [\#141](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/141)
  * Developer Guide:
    * Added user stories and use cases. [\#25](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/25)
* **Community**:
  * PRs reviewed (with non-trivial review comments): [\#221](https://github.com/AY2324S2-CS2103T-F11-4/tp/pull/221)
