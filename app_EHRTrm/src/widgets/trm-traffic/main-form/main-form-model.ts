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
        prop: 'trmtrafficid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'trmtrafficname',
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
        name: 'trmtrafficname',
        prop: 'trmtrafficname',
        dataType: 'TEXT',
      },
      {
        name: 'jtfs',
        prop: 'jtfs',
        dataType: 'SSCODELIST',
      },
      {
        name: 'xlmc',
        prop: 'xlmc',
        dataType: 'TEXT',
      },
      {
        name: 'trmtrainaddressid',
        prop: 'trmtrainaddressid',
        dataType: 'PICKUP',
      },
      {
        name: 'trmtrafficid',
        prop: 'trmtrafficid',
        dataType: 'GUID',
      },
      {
        name: 'trmtraffic',
        prop: 'trmtrafficid',
        dataType: 'FONTKEY',
      },
    ]
  }

}