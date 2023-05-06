Feature: Test

  Background:
    When Login to reportportal
    Then Click Launches option
    When Wait all launches are displayed

  @DDT
  Scenario Outline: Validate column names
    Then Columns list has "<columnName>"
    Examples:
      | columnName     |
      | NAME           |
      | START TIME     |
      | TOTAL          |
      | PASSED         |
      | FAILED         |
      | SKIPPED        |
      | PRODUCT BUG    |
      | AUTO BUG       |
      | SYSTEM ISSUE   |
      | TO INVESTIGATE |

  @DDT
  Scenario Outline: Validate menu actions
    When Wait hamburger icon is displayed
    When Click hamburger icon
    Then Menu actions have "<menuAction>"
    Examples:
      | menuAction            |
      | Move to debug         |
      | Force finish          |
      | Analysis              |
      | Unique Error analysis |
      | Pattern analysis      |
      | Delete                |

  @DDT
  Scenario Outline: Validate more list
    When Wait hamburger icon is displayed
    When Click first launch
    When Click more button
    Then More list have "<moreListOption>"
    Examples:
      | moreListOption |
      | Start time     |
      | Description    |
      | Attribute      |
      | Total          |
      | Passed         |
      | Failed         |
      | Skipped        |
      | Product bug    |
      | Automation bug |
      | System issue   |
      | To investigate |