/**
 * PLDD 部件模型
 *
 * @export
 * @class PLDDModel
 */
export default class PLDDModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof PLDDModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'pcmddsqdid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pcmddsqdname',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'pcmddsqdid',
        prop: 'pcmddsqdid',
        dataType: 'GUID',
      },
      {
        name: 'pcmddsqd',
        prop: 'pcmddsqdid',
        dataType: 'FONTKEY',
      },
    ]
  }

}