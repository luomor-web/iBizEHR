<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SocArchivesMain2EditViewBase from './soc-archives-main2-edit-view-base.vue';

import view_form from '@widgets/soc-archives/main2-form/main2-form.vue';

/**
 * 社保档案编辑视图
 *
 * @export
 * @class SocArchivesMain2EditView
 * @extends {SocArchivesMain2EditViewBase}
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
export default class SocArchivesMain2EditView extends SocArchivesMain2EditViewBase { }
</script>