<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimSearchModalEditViewBase from './pim-search-modal-edit-view-base.vue';

import view_form from '@widgets/pim-search-modal/main-form/main-form.vue';

/**
 * 组合查询模版编辑视图
 *
 * @export
 * @class PimSearchModalEditView
 * @extends {PimSearchModalEditViewBase}
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
export default class PimSearchModalEditView extends PimSearchModalEditViewBase { }
</script>