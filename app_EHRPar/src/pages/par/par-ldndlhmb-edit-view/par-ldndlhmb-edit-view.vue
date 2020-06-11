<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ParLdndlhmbEditViewBase from './par-ldndlhmb-edit-view-base.vue';

import view_form from '@widgets/par-ldndlhmb/main-form/main-form.vue';

/**
 * 年度量化目标（助理总经理级领导 ）编辑视图
 *
 * @export
 * @class ParLdndlhmbEditView
 * @extends {ParLdndlhmbEditViewBase}
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
export default class ParLdndlhmbEditView extends ParLdndlhmbEditViewBase { }
</script>