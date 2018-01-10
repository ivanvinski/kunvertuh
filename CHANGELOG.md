# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/)
and this project adheres to [Semantic Versioning](http://semver.org/spec/v2.0.0.html).

## Unreleased
### Added
- Active view null check when updating app bar title so `NullPointerException` would not be thrown
in case active view was not set
- Unit tests for MainPresenter
- Unit tests for ConverterPresenter
- Unit tests for AboutPresenter
- Settings persistence - settings are now saved
- Temperature units conversion
- Speed units conversion
- Time units conversion
- Pressure units conversion
- Angle units conversion
- Data transfer rate units conversion
- Digital storage units conversion

### Changed
- Refactored a few classes for easier testability
- Separated language and number format setting into two settings

## [0.2.0] - 2018-01-04
### Added
- Concrete, generic converter view implementation
- Converter view template FXML file
- Concrete, abstract presenter abstract class
- Concrete, generic converter presenter
- About model
- Views loaded event so the main view doesn't depend on view loading order
- Better model-view-presenter loaders/managers
- Updated license and file headers

### Changed
- Refactored and cleaned up view abstractions and implementations
- Redesigned About view
- Refactored and cleaned up presenters
- Presenters now handle internationalization instead of views
- Refactored and cleaned up models
- Replaced dependency injection library with view factory
- Restructured project packages
- Decoupled HostServices

### Removed
- Specific converter view implementations
- Specific converter view FXML files
- Specific converter presenters
- Outdated model-view-presenter loaders/managers

## [0.1.0] - 2017-12-28
- Initial release
