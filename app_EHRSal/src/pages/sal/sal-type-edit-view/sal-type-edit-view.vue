<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalTypeEditViewBase from './sal-type-edit-view-base.vue';

import view_form from '@widgets/sal-type/main-form/main-form.vue';

/**
 * 薪酬类型编辑视图
 *
 * @export
 * @class SalTypeEditView
 * @extends {SalTypeEditViewBase}
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
export default class SalTypeEditView extends SalTypeEditViewBase { }
</script>