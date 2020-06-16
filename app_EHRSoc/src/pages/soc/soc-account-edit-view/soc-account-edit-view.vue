<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SocAccountEditViewBase from './soc-account-edit-view-base.vue';

import view_form from '@widgets/soc-account/main-form/main-form.vue';

/**
 * 参保账户编辑视图
 *
 * @export
 * @class SocAccountEditView
 * @extends {SocAccountEditViewBase}
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
export default class SocAccountEditView extends SocAccountEditViewBase { }
</script>