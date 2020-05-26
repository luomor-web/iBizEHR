<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import XD_SZBase from './xd-sz-wizardpanel-base.vue';
import view_wizardpanel_form_wizard04 from '@widgets/pcmprofile/zczsxdy-form/zczsxdy-form.vue';
import view_wizardpanel_form_wizard05 from '@widgets/pcmprofile/hjqkxdy-form/hjqkxdy-form.vue';
import view_wizardpanel_form_wizard01 from '@widgets/pcmprofile/szypzxxxdy-form/szypzxxxdy-form.vue';
import view_wizardpanel_form_wizard02 from '@widgets/pcmprofile/jybjxdy-form/jybjxdy-form.vue';
import view_wizardpanel_form_wizard03 from '@widgets/pcmprofile/gzllxdy-form/gzllxdy-form.vue';

 
@Component({
    components: {
        view_wizardpanel_form_wizard04, 
        view_wizardpanel_form_wizard05, 
        view_wizardpanel_form_wizard01, 
        view_wizardpanel_form_wizard02, 
        view_wizardpanel_form_wizard03, 
         
    }
})
export default class XD_SZ extends XD_SZBase {

}
</script>