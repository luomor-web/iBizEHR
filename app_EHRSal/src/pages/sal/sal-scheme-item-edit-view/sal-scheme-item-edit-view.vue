<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalSchemeItemEditViewBase from './sal-scheme-item-edit-view-base.vue';

import view_form from '@widgets/sal-scheme-item/main-form/main-form.vue';

/**
 * 方案要素项编辑视图
 *
 * @export
 * @class SalSchemeItemEditView
 * @extends {SalSchemeItemEditViewBase}
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
export default class SalSchemeItemEditView extends SalSchemeItemEditViewBase { }
</script>