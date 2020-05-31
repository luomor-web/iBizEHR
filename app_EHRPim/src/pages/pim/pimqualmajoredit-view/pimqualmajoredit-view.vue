<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMQUALMAJOREditViewBase from './pimqualmajoredit-view-base.vue';

import view_form from '@widgets/pim-qual-major/main-form/main-form.vue';

/**
 * 执业资格专业
 *
 * @export
 * @class PIMQUALMAJOREditView
 * @extends {PIMQUALMAJOREditViewBase}
 */
@Component({
    components: {
        view_form, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PIMQUALMAJOREditView extends PIMQUALMAJOREditViewBase { }
</script>