<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimSearchFieldSetComPlexSearchCustomViewBase from './pim-search-field-set-com-plex-search-custom-view-base.vue';


/**
 * 组合查询
 *
 * @export
 * @class PimSearchFieldSetComPlexSearchCustomView
 * @extends {PimSearchFieldSetComPlexSearchCustomViewBase}
 */
@Component({
    components: {
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PimSearchFieldSetComPlexSearchCustomView extends PimSearchFieldSetComPlexSearchCustomViewBase { }
</script>