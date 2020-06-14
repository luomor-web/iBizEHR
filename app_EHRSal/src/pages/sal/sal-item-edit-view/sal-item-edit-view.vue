<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalItemEditViewBase from './sal-item-edit-view-base.vue';

import view_form from '@widgets/sal-item/main-form/main-form.vue';

/**
 * 薪酬要素项编辑视图
 *
 * @export
 * @class SalItemEditView
 * @extends {SalItemEditViewBase}
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
export default class SalItemEditView extends SalItemEditViewBase { }
</script>