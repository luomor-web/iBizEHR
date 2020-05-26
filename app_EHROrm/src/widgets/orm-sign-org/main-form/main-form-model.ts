/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
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
        prop: 'ormsignorgid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'ormsignorgname',
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
        name: 'orgcode',
        prop: 'orgcode',
        dataType: 'TEXT',
      },
      {
        name: 'ormsignorgname',
        prop: 'ormsignorgname',
        dataType: 'TEXT',
      },
      {
        name: 'zzjc',
        prop: 'zzjc',
        dataType: 'TEXT',
      },
      {
        name: 'ormsignorgid',
        prop: 'ormsignorgid',
        dataType: 'GUID',
      },
      {
        name: 'ormsignorg',
        prop: 'ormsignorgid',
        dataType: 'FONTKEY',
      },
    ]
  }

}