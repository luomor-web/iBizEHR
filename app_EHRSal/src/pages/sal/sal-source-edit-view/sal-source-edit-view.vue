<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalSourceEditViewBase from './sal-source-edit-view-base.vue';

import view_form from '@widgets/sal-source/main-form/main-form.vue';

/**
 * 薪酬计算源编辑视图
 *
 * @export
 * @class SalSourceEditView
 * @extends {SalSourceEditViewBase}
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
export default class SalSourceEditView extends SalSourceEditViewBase { }
</script>