<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import KQGZSTXDBase from './kqgzstxd-wizardpanel-base.vue';
import view_wizardpanel_form_wizard01 from '@widgets/vac-holiday-rules/jqgz-form/jqgz-form.vue';
import view_wizardpanel_form_wizard02 from '@widgets/vac-holiday-rules/jjrtxsb-form/jjrtxsb-form.vue';
import view_wizardpanel_form_wizard03 from '@widgets/vac-holiday-rules/qjts-form/qjts-form.vue';

 
@Component({
    components: {
        view_wizardpanel_form_wizard01, 
        view_wizardpanel_form_wizard02, 
        view_wizardpanel_form_wizard03, 
         
    }
})
export default class KQGZSTXD extends KQGZSTXDBase {

}
</script>