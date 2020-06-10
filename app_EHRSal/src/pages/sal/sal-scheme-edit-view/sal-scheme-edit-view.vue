<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalSchemeEditViewBase from './sal-scheme-edit-view-base.vue';

import view_form from '@widgets/sal-scheme/main-form/main-form.vue';

/**
 * 薪酬方案编辑视图
 *
 * @export
 * @class SalSchemeEditView
 * @extends {SalSchemeEditViewBase}
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
export default class SalSchemeEditView extends SalSchemeEditViewBase { }
</script>