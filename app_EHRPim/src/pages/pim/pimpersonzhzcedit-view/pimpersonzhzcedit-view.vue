<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONZHZCEditViewBase from './pimpersonzhzcedit-view-base.vue';

import view_form from '@widgets/pim-person/ryinfo-form-3-form/ryinfo-form-3-form.vue';

/**
 * 证书信息编辑视图
 *
 * @export
 * @class PIMPERSONZHZCEditView
 * @extends {PIMPERSONZHZCEditViewBase}
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
export default class PIMPERSONZHZCEditView extends PIMPERSONZHZCEditViewBase { }
</script>