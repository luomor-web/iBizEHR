<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import XD_QTZPBase from './xd-qtzp-wizardpanel-base.vue';
import view_wizardpanel_form_wizard04 from '@widgets/pcmprofile/gzllxdy-form/gzllxdy-form.vue';
import view_wizardpanel_form_wizard01 from '@widgets/pcmprofile/qtzpypzxxxdy-form/qtzpypzxxxdy-form.vue';
import view_wizardpanel_form_wizard02 from '@widgets/pcmprofile/jybjxdy-form/jybjxdy-form.vue';
import view_wizardpanel_form_wizard03 from '@widgets/pcmprofile/hjqkxdy-form/hjqkxdy-form.vue';

 
@Component({
    components: {
        view_wizardpanel_form_wizard04, 
        view_wizardpanel_form_wizard01, 
        view_wizardpanel_form_wizard02, 
        view_wizardpanel_form_wizard03, 
         
    }
})
export default class XD_QTZP extends XD_QTZPBase {

}
</script>