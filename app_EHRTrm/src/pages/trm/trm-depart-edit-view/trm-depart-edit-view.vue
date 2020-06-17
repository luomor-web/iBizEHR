<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmDepartEditViewBase from './trm-depart-edit-view-base.vue';

import view_form from '@widgets/trm-depart/main-form/main-form.vue';

/**
 * 需求通知
 *
 * @export
 * @class TrmDepartEditView
 * @extends {TrmDepartEditViewBase}
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
export default class TrmDepartEditView extends TrmDepartEditViewBase { }
</script>