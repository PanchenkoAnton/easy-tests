layout 'layout/main.tpl', title:  'User',
content: contents {
  h4 ('Test')
  form (class:'col s12', method:'post') {
    input (type:'hidden', name:_csrf.parameterName, value:_csrf.token)
    div (class:'row') {
      div (class:'input-field col s4') {
        if (errors && errors.hasFieldErrors('name')) {
          input (id:'name', name:'name', type:'text', class:'validate invalid', value:errors.getFieldValue('name'))
          label (for:'name', 'data-error':errors.getFieldErrors('name')*.getDefaultMessage().join(', '), 'name')
        } else {
          input (id:'name', name:'name', type:'text', class:'validate', value:test.getName())
          label (for:'name', 'name')
        }
      }
      div (class:'input-field col s4') {
        if (errors && errors.hasFieldErrors('value')) {
          input (id:'value', name:'value', type:'text', class:'validate invalid', value:errors.getFieldValue('value'))
          label (for:'value', 'data-error':errors.getFieldErrors('value')*.getDefaultMessage().join(', '), 'value')
        } else {
          input (id:'value', name:'value', type:'text', class:'validate', value:test.getValue())
          label (for:'value', 'value')
        }
      }
    }
    def id = 0;
    test.subTests.each { subTest ->
      div (class:'row') {
        div (class:'input-field col s4') {
          def inputId = 'subTests_id_' + id
          def inputName =  'subTests[' + id + '].id'
          if (errors && errors.hasFieldErrors('subTests['+id+'].id')) {
            input (id:inputId, name:inputName, type:'text', class:'validate invalid', value:errors.getFieldValue(inputName))
            label (for:inputId, 'data-error':errors.getFieldErrors(inputName)*.getDefaultMessage().join(', '), 'Id')
          } else {
            input (id:inputId, name:inputName, type:'text', class:'validate', value:subTest.getId())
            label (for:inputId, 'Id')
          }
        }
        div (class:'input-field col s4') {
          def inputId = 'subTests_name_' + id
          def inputName =  'subTests[' + id + '].name'
          if (errors && errors.hasFieldErrors(inputName)) {
            input (id:inputId, name:inputName, type:'text', class:'validate invalid', value:errors.getFieldValue(inputName))
            label (for:inputId, 'data-error':errors.getFieldErrors(inputName)*.getDefaultMessage().join(', '), 'Name')
          } else {
            input (id:inputId, name:inputName, type:'text', class:'validate', value:subTest.getName())
            label (for:inputId, 'Name')
          }
        }
      }
      id++
    }

    div (class:'row') {
      div (class:'col s12') {
        button (class:'waves-effect waves-light btn-large blue', type:'submit') {
          i (class:'material-icons left', 'save')
          yield 'Submit'
        }
      }
    }
  }
}
