<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SocAreaEditViewBase from './soc-area-edit-view-base.vue';

import view_form from '@widgets/soc-area/main-form/main-form.vue';

/**
 * 参保地编辑视图
 *
 * @export
 * @class SocAreaEditView
 * @extends {SocAreaEditViewBase}
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
export default class SocAreaEditView extends SocAreaEditViewBase { }
</script>