<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VACLEAVEDETAILJHQJMX_EditViewBase from './vacleavedetailjhqjmx-edit-view-base.vue';

import view_form from '@widgets/vac-leave-detail/jhqjmx-form/jhqjmx-form.vue';

/**
 * 请假明细
 *
 * @export
 * @class VACLEAVEDETAILJHQJMX_EditView
 * @extends {VACLEAVEDETAILJHQJMX_EditViewBase}
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
export default class VACLEAVEDETAILJHQJMX_EditView extends VACLEAVEDETAILJHQJMX_EditViewBase { }
</script>