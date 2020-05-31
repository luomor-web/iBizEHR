<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VACLEAVEDETAILSJQJMX_CK_EditViewBase from './vacleavedetailsjqjmx-ck-edit-view-base.vue';

import view_form from '@widgets/vac-leave-detail/sjqjmx-ck-form/sjqjmx-ck-form.vue';

/**
 * 请假明细
 *
 * @export
 * @class VACLEAVEDETAILSJQJMX_CK_EditView
 * @extends {VACLEAVEDETAILSJQJMX_CK_EditViewBase}
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
export default class VACLEAVEDETAILSJQJMX_CK_EditView extends VACLEAVEDETAILSJQJMX_CK_EditViewBase { }
</script>