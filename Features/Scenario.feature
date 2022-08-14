Feature: DT Testing Chapter Automation Coding Test


  Scenario Outline: Verify adding a item to the list

    Given navigate to the given URL in a Browser

    When add the item '<items>' to the list

    Then check the added item '<items>'
    Examples:
      | items                                                |
      | item1 |
      
   Scenario Outline: Verify making the item completed

    Given navigate to the given URL in a Browser
    When add the item '<items>' to the list
    Then mark the added item '<items>' completed
    Examples:
      | item                                                 |
      | item1 |

  Scenario Outline: Verify fetching all the items added in the list.

    Given navigate to the given URL in a Browser
    When add the item '<item1>','<item2>' to the list
    Then get the count of '<item2>' added
    Examples:
      | item1    | item2    |
      | AddItem1 | Additem2 |

  Scenario Outline: Verify fetching all the completed items added as completed

    Given navigate to the given URL in a Browser
    When add the item '<item1>','<item2>' to the list
    Then select the completed '<item1>'
    Examples:
      | item1    | item2    | item3    |
      | AddItem1 | Additem2 | Additem3 |

  Scenario Outline: Verify deleting the item added in the list.

    Given navigate to the given URL in a Browser
    When add the item '<item1>' to the list
    Then delete the item added '<item1>'
    Examples:
      | item1    | item2    | item3    |
      | AddItem1 | Additem2 | Additem3 |

