<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimDistirbutionEditViewBase from './pim-distirbution-edit-view-base.vue';

import view_form from '@widgets/pim-distirbution/main-form/main-form.vue';

/**
 * 分配信息编辑视图
 *
 * @export
 * @class PimDistirbutionEditView
 * @extends {PimDistirbutionEditViewBase}
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
export default class PimDistirbutionEditView extends PimDistirbutionEditViewBase { }
</script>