<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONZDDEditViewBase from './pimpersonzddedit-view-base.vue';

import view_form from '@widgets/pim-person/read-ryinfo-form-form/read-ryinfo-form-form.vue';

/**
 * 人员首页编辑视图
 *
 * @export
 * @class PIMPERSONZDDEditView
 * @extends {PIMPERSONZDDEditViewBase}
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
export default class PIMPERSONZDDEditView extends PIMPERSONZDDEditViewBase { }
</script>