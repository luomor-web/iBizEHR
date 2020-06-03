<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimSearchFieldSetEditViewBase from './pim-search-field-set-edit-view-base.vue';

import view_form from '@widgets/pim-search-field-set/main-form/main-form.vue';

/**
 * 组合查询条件设置编辑视图
 *
 * @export
 * @class PimSearchFieldSetEditView
 * @extends {PimSearchFieldSetEditViewBase}
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
export default class PimSearchFieldSetEditView extends PimSearchFieldSetEditViewBase { }
</script>