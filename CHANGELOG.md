# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/)
and this project adheres to [Semantic Versioning](http://semver.org/spec/v2.0.0.html).

## UNRELEASED
### Added
- Concrete, generic converter view implementation
- Converter view template FXML file
- Concrete, abstract presenter abstract class
- Concrete, generic converter presenter
- About model
- Views loaded event so the main view doesn't depend on view loading order
- Better model-view-presenter loaders/managers

### Changed
- Refactored and cleaned up view abstractions and implementations
- Redesigned About view
- Refactored and cleaned up presenters
- Presenters now handle internationalization instead of views
- Refactored and cleaned up models
- Replaced dependency injection library with view factory

### Removed
- Specific converter view implementations
- Specific converter view FXML files
- Specific converter presenters
- Outdated model-view-presenter loaders/managers

## [0.1.0] - 2017-12-28
- Initial release
