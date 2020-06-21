<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SocArchivesDetailEditViewBase from './soc-archives-detail-edit-view-base.vue';

import view_form from '@widgets/soc-archives-detail/main-form/main-form.vue';

/**
 * 社保档案明细编辑视图
 *
 * @export
 * @class SocArchivesDetailEditView
 * @extends {SocArchivesDetailEditViewBase}
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
export default class SocArchivesDetailEditView extends SocArchivesDetailEditViewBase { }
</script>