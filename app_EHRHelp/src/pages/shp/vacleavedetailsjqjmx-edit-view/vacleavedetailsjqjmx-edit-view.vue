<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VACLEAVEDETAILSJQJMX_EditViewBase from './vacleavedetailsjqjmx-edit-view-base.vue';

import view_form from '@widgets/vacleavedetail/sjqjmx-form/sjqjmx-form.vue';

/**
 * 请假明细
 *
 * @export
 * @class VACLEAVEDETAILSJQJMX_EditView
 * @extends {VACLEAVEDETAILSJQJMX_EditViewBase}
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
export default class VACLEAVEDETAILSJQJMX_EditView extends VACLEAVEDETAILSJQJMX_EditViewBase { }
</script>