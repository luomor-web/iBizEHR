<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import KQSZXDBase from './kqszxd-wizardpanel-base.vue';
import view_wizardpanel_form_wizard01 from '@widgets/att-endence-setup/kqsz-form/kqsz-form.vue';
import view_wizardpanel_form_wizard02 from '@widgets/att-endence-setup/kqbm-form/kqbm-form.vue';
import view_wizardpanel_form_wizard03 from '@widgets/att-endence-setup/bmygkqsz-form/bmygkqsz-form.vue';

 
@Component({
    components: {
        view_wizardpanel_form_wizard01, 
        view_wizardpanel_form_wizard02, 
        view_wizardpanel_form_wizard03, 
         
    }
})
export default class KQSZXD extends KQSZXDBase {

}
</script>