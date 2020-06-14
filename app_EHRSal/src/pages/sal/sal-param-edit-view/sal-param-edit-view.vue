<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalParamEditViewBase from './sal-param-edit-view-base.vue';

import view_form from '@widgets/sal-param/main-form/main-form.vue';

/**
 * 薪酬计算指标编辑视图
 *
 * @export
 * @class SalParamEditView
 * @extends {SalParamEditViewBase}
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
export default class SalParamEditView extends SalParamEditViewBase { }
</script>