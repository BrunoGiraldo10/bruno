
Feature: Temperatura de Peru
  @BUSCATEMPERATURA
  Scenario: Temperatura de Lima
    Given que me encuentro en el buscador
    When busco la temperatura de lima
    Then me muestra los grados actuales