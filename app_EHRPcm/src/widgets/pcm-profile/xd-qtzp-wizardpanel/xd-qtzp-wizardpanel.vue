<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import XD_QTZPBase from './xd-qtzp-wizardpanel-base.vue';
import view_wizardpanel_form_wizard04 from '@widgets/pcm-profile/gzllxdy-form/gzllxdy-form.vue';
import view_wizardpanel_form_wizard01 from '@widgets/pcm-profile/qtzpypzxxxdy-form/qtzpypzxxxdy-form.vue';
import view_wizardpanel_form_wizard02 from '@widgets/pcm-profile/jybjxdy-form/jybjxdy-form.vue';
import view_wizardpanel_form_wizard03 from '@widgets/pcm-profile/hjqkxdy-form/hjqkxdy-form.vue';

 
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